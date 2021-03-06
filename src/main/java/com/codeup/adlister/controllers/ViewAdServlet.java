package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "controllers.ViewAdServlet", urlPatterns= "/ad")

public class ViewAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("ad", DaoFactory.getAdsDao().findAdById(Long.parseLong(request.getParameter("ad_id"))));

            Ad ad = (Ad) request.getAttribute("ad");
            Long id = ad.getUserId();
            request.setAttribute("email", DaoFactory.getUsersDao().findUserById(id).getEmail());
            request.getRequestDispatcher("/WEB-INF/ads/single_ad.jsp").forward(request, response);
            request.getSession().setAttribute("ad", ad);
        } else {
            //user is not allowed to edit ads if they are not logged in--
            //still need to specify that the userId matches the logged in user.
            request.setAttribute("ad", DaoFactory.getAdsDao().findAdById(Long.parseLong(request.getParameter("ad_id"))));
            Ad ad = (Ad) request.getAttribute("ad");
            Long id = ad.getUserId();
            request.setAttribute("email", DaoFactory.getUsersDao().findUserById(id).getEmail());
            request.getRequestDispatcher("/WEB-INF/ads/single_ad.jsp").forward(request,response);
        }
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            long id = Long.parseLong(request.getParameter("ad_id"));
//            DaoFactory.getAdsDao().deleteAd(id);
            request.getRequestDispatcher("/WEB-INF/ads/single_ad.jsp").forward(request,response);

        }
    }
