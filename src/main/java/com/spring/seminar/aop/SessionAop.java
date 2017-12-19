package com.spring.seminar.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class SessionAop {

	@Pointcut("within(com.spring.seminar.UserLoginServiceController)")
	private void controllerMethod() {
	}

	@Around(value = "controllerMethod() ")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

		/*System.out.println("#### LoginAspect 시작 ####");
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		String strUrl = req.getRequestURL().toString();

		for (Object o : joinPoint.getArgs()) {
			if (o instanceof HttpServletRequest) {
				req = (HttpServletRequest) o;
			}

		}

		if (!strUrl.endsWith("/")) {
			try {
				HttpSession session = req.getSession();

				String loginId = (String) session.getAttribute("id");

				System.out.println("### Margo ==> loginId : " + loginId);
				if (loginId == null || "".equals(loginId)) {
					System.out.println("### Margo ==> in if loginId : " + loginId);
					throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
				}
			} catch (Exception e) {

				throw new RuntimeException("먼저 로그인을 하셔야 합니다.");

			}

		}*/
		Object result = joinPoint.proceed();
		System.out.println("#### LoginAspect 끝 ####");
		return result;

	}
}
