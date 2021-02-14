package link.bosswang.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * MVC启动初始化类
 */
public class StudyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 提供Root ApplicationContext初始化的配置类
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ServiceConfig.class};
	}

	/**
	 * 提供Servlet applicationContext初始化的配置类
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{MvcConfig.class};
	}

	/**
	 * 配置servlet的处理路径
	 *
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
