package com.spring.seminar.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.seminar.UserLoginServiceController;
import com.spring.seminar.dto.Log;
import com.spring.seminar.mapper.UsersMapper;
import com.spring.seminar.service.AdminLogManagerService;
import com.spring.seminar.service.AdminMainService;
import com.spring.seminar.service.UserLoginService;

@Aspect
public class LogAop {

	@Autowired(required = false)
	AdminLogManagerService AdminLogManagerService;

	@Autowired(required = false)
	private UserLoginService userLoginService;

	@Autowired(required = false)
	AdminMainService adminMainService;

	String userName = "init";
	String password = "0000";
	String logIp = "";
	
	ParseContent parseContent = new ParseContent();

	@Pointcut("within(com.spring.seminar.*)")
	private void pointcutMethod() {
	}

	@Around(value = "pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {

		int logId = 0;

		String methodName = joinpoint.getSignature().getName();
		String optionContent = optionContent(joinpoint.getArgs(), methodName);
		System.out.println("optionContent : " + optionContent);

		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder
											.currentRequestAttributes()).getRequest();
		req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		logIp = getWebAccessIp(req);

		String userNameTemp = userName;
		String passwordTemp = password;
		String joipointStringTemp = joinpoint.getSignature().toShortString();

		if (!userLoginService.getUserByUserNameAndIsAdmin(userNameTemp, passwordTemp, "y")//관리자 권한인지 파악
				&& !userNameTemp.equals("init") && !passwordTemp.equals("0000")//변수 초기값에 대한 조건
				&& !joipointStringTemp.contains("HomeController.home(..)")) {//웹 첫페이지에 대한 joinpoint 메소드 명 제외 조건
			
			Log log = new Log();
			log.setLogId(logId++);
			log.setLogUserName(userNameTemp);
			log.setLogContent(parseContent.parseContentReturn(joinpoint.getSignature().toShortString()));
			log.setIpAddress(logIp);
			AdminLogManagerService.logInsert(log);
			
		}

		// 다음 메소드가 나오면 해당 Id의 로그인 Hit를 업데이트해줌
		if (joipointStringTemp.contains("HomeController.loginProcess(..)")) {
			try {
				adminMainService.accessLogLogInHit(userName);
				// 로그 정보가 없어서 익셉션 발생시 예외 처리
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {

		}

	}

	private String optionContent(Object[] args, String mName) {
		if (args == null) {
			return null;
		}
		StringBuffer rs = new StringBuffer();
		rs.append(mName);
		String className = null;
		int index = 1;

		// 매개 변수 대상 사이를 옮겨다니기
		for (Object info : args) {
			// 개체 유형 가져오기
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[인자 " + index + "종류:" + className + "값:");
			// 대상 모든 방법을 가져오기
			Method[] methods = info.getClass().getDeclaredMethods();
			// 사이를 옮겨다니기 방법을 판단 get 방법
			for (Method method : methods) {
				String methodName = method.getName();
				// 판단 혹시 get 방법
				if (methodName.indexOf("get") == -1) {// get 방법이 아니다.
					continue;// 처리할 수 없다
				}
				Object rsValue = null;
				try {
					// 호출 get 방법을 가져오기 복귀 값
					rsValue = method.invoke(info);
				} catch (Exception e) {
					continue;
				}
				
				rs.append("(" + methodName + ":" + rsValue + ")");
		
				if (methodName.equals("getUserName")) {
					System.out.println("rsValue:" + rsValue);
					userName = (String) rsValue;
				}
				
				if (methodName.equals("getPassword")) {
					password = (String) rsValue;
				}
			}
			rs.append("]");
			index++;
		}
		return rs.toString();
	}

	private String getWebAccessIp(HttpServletRequest req) {

		logIp = req.getHeader("X-FORWARDED-FOR");
		if (logIp == null || logIp.length() == 0) {
			logIp = req.getHeader("Proxy-Client-IP");
		}

		if (logIp == null || logIp.length() == 0) {
			logIp = req.getHeader("WL-Proxy-Client-IP"); // 웹로직
		}

		if (logIp == null || logIp.length() == 0) {
			logIp = req.getRemoteAddr();
		}
		return logIp;
	}

	@Before("pointcutMethod()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("beforeAdvice()");
	}

	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}

	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}

	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}

}
