package com.example.boottest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class CookieController {
    private static final Logger logger = LoggerFactory.getLogger(CookieController.class);

    @GetMapping("/test/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            logger.info("不存在session, 设置browser={}", browser);
            session.setAttribute("browser", browser);
        } else {
            logger.info("存在session, browser={}", sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                logger.info(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "index";
    }
}
