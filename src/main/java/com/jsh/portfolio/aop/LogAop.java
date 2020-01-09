package com.jsh.portfolio.aop;

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

import com.jsh.portfolio.controller.UserLoginServiceController;
import com.jsh.portfolio.dto.Log;
import com.jsh.portfolio.mapper.UsersMapper;
import com.jsh.portfolio.service.AdminLogManagerService;
import com.jsh.portfolio.service.AdminMainService;
import com.jsh.portfolio.service.UserLoginService;

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

	@Pointcut("within(com.jsh.portfolio.*)")
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

		if (!userLoginService.getUserByUserNameAndIsAdmin(userNameTemp, passwordTemp, "y")//������ �������� �ľ�
				&& !userNameTemp.equals("init") && !passwordTemp.equals("0000")//���� �ʱⰪ�� ���� ����
				&& !joipointStringTemp.contains("HomeController.home(..)")) {//�� ù�������� ���� joinpoint �޼ҵ� �� ���� ����
			
			Log log = new Log();
			log.setLogId(logId++);
			log.setLogUserName(userNameTemp);
			log.setLogContent(parseContent.parseContentReturn(joinpoint.getSignature().toShortString()));
			log.setIpAddress(logIp);
			AdminLogManagerService.logInsert(log);
			
		}

		// ���� �޼ҵ尡 ������ �ش� Id�� �α��� Hit�� ������Ʈ����
		if (joipointStringTemp.contains("HomeController.loginProcess(..)")) {
			try {
				adminMainService.accessLogLogInHit(userName);
				// �α� ������ ��� �ͼ��� �߻��� ���� ó��
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

		// �Ű� ���� ���? ���̸� �Űܴٴϱ�
		for (Object info : args) {
			// ��ü ���� ��������
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[���� " + index + "����:" + className + "��:");
			// ���? ���? �����? ��������
			Method[] methods = info.getClass().getDeclaredMethods();
			// ���̸� �Űܴٴϱ� �����? �Ǵ� get ���?
			for (Method method : methods) {
				String methodName = method.getName();
				// �Ǵ� Ȥ�� get ���?
				if (methodName.indexOf("get") == -1) {// get �����? �ƴϴ�.
					continue;// ó���� �� ����
				}
				Object rsValue = null;
				try {
					// ȣ�� get �����? �������� ���� ��
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
			logIp = req.getHeader("WL-Proxy-Client-IP"); // ������
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
