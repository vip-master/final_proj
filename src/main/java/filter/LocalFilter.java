package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocalFilter implements Filter {
    private static final String LOCALE = "locale";
    private static final String BUNDLE = "bundle";
    private String defaultBundle;
    private String locale;

    @Override
    public void init(FilterConfig filterConfig) {
        defaultBundle = filterConfig.getInitParameter(BUNDLE);
        locale = filterConfig.getInitParameter(LOCALE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        setLocale(httpRequest);
        setBundle(httpRequest);

        filterChain.doFilter(request, response);
    }

    private void setBundle(HttpServletRequest httpRequest) {
        if (httpRequest.getSession().getAttribute(BUNDLE) == null) {
            httpRequest.getSession().setAttribute(BUNDLE, defaultBundle);
        }
    }

    private void setLocale(HttpServletRequest httpRequest) {
        if (httpRequest.getSession().getAttribute(LOCALE) == null) {
            httpRequest.getSession().setAttribute(LOCALE, locale);
        }
    }

    @Override
    public void destroy() {

    }
}
