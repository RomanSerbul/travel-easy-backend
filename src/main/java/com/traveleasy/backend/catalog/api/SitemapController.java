package com.traveleasy.backend.catalog.api;

import com.traveleasy.backend.catalog.domain.TourProposal;
import com.traveleasy.backend.catalog.repository.TourProposalRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SitemapController {

    private final TourProposalRepository tourProposalRepository;
    private final String siteUrl;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;

    public SitemapController(
            TourProposalRepository tourProposalRepository,
            @Value("${app.url:https://easy-travel.com.ua}") String siteUrl) {
        this.tourProposalRepository = tourProposalRepository;
        this.siteUrl = siteUrl;
    }

    @GetMapping(value = "/sitemap.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String generateSitemap() {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");

        String today = LocalDate.now().format(DATE_FORMAT);

        // Static pages
        addUrl(xml, "/home", today, "weekly", "1.0");
        addUrl(xml, "/catalog", today, "daily", "0.9");
        addUrl(xml, "/about", today, "monthly", "0.7");
        addUrl(xml, "/contact", today, "monthly", "0.7");
        addUrl(xml, "/gallery", today, "weekly", "0.6");
        addUrl(xml, "/faq", today, "monthly", "0.6");

        // Dynamic tour pages
        List<TourProposal> tours = tourProposalRepository.findAll();
        for (TourProposal tour : tours) {
            String lastMod = tour.getUpdatedAt() != null 
                ? tour.getUpdatedAt().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMAT) 
                : today;
            addUrl(xml, "/tour/" + tour.getSlug(), lastMod, "weekly", "0.8");
        }

        xml.append("</urlset>");
        return xml.toString();
    }

    @GetMapping(value = "/robots.txt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getRobots() {
        return """
            User-agent: *
            Allow: /
            
            Disallow: /admin
            Disallow: /login
            
            User-agent: Googlebot
            Allow: /
            
            User-agent: Bingbot
            Allow: /
            
            Sitemap: %s/sitemap.xml
            
            Crawl-delay: 1
            """.formatted(siteUrl);
    }

    private void addUrl(StringBuilder xml, String path, String lastMod, String changeFreq, String priority) {
        xml.append("  <url>\n");
        xml.append("    <loc>").append(siteUrl).append(path).append("</loc>\n");
        xml.append("    <lastmod>").append(lastMod).append("</lastmod>\n");
        xml.append("    <changefreq>").append(changeFreq).append("</changefreq>\n");
        xml.append("    <priority>").append(priority).append("</priority>\n");
        xml.append("  </url>\n");
    }
}
