package by.bsac.filter;

import by.bsac.profile.ProfileTools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SessionFilter implements Filter {
    private ArrayList<String> ignoredUrlList;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestUri = req.getRequestURI();
        boolean shouldBeIgnored = isIgnoredUrl(requestUri);
        if (!shouldBeIgnored && !ProfileTools.isLoggedIn(req)) {
            request.getServletContext().
                    getRequestDispatcher("/BSAC/login.jsp").
                    forward(request, response);

        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) {
        ignoredUrlList = new ArrayList<>();
        String urls = config.getInitParameter("ignore-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
        while (token.hasMoreTokens()) {
            ignoredUrlList.add("/study_pz3_war" + token.nextToken());
        }
    }

    private boolean isIgnoredUrl(String url) {
        for (String ignoredUrl : getIgnoredUrlList()) {
            System.out.println(ignoredUrl);
            if (url.startsWith(ignoredUrl)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getIgnoredUrlList() {
        return ignoredUrlList;
    }

    public void setIgnoredUrlList(ArrayList<String> urlList) {
        this.ignoredUrlList = urlList;
    }
}
