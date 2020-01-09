package com.jsh.portfolio.aop;

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

	@Pointcut("within(com.jsh.portfolio.UserLoginServiceController)")
	private void controllerMethod() {
	}

	@Around(value = "controllerMethod() ")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

		/*System.out.println("#### LoginAspect ?‹œ?‘ ####");
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
					throw new RuntimeException("ë¨¼ì? ë¡œê·¸?¸?„ ?•˜?…”?•¼ ?•©?‹ˆ?‹¤.");
				}
			} catch (Exception e) {

				throw new RuntimeException("ë¨¼ì? ë¡œê·¸?¸?„ ?•˜?…”?•¼ ?•©?‹ˆ?‹¤.");

			}

		}*/
		Object result = joinPoint.proceed();
		System.out.println("#### LoginAspect ? ####");
		return result;

	}
}
