package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final int TIMEOUT = 5 * 1000;
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    private static final String referrer = "http://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";

    @Override
    public List<Vacancy> getVacancies(String searchString){
        int num = 0;
        List<Vacancy> list = new ArrayList<>();
        try
        {
            while (true)
            {
                Document doc = getDocument(searchString, num++);
                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0)
                    break;
                for(Element element : elements){
                    Vacancy vacancy = new Vacancy();
                    Element elementTitle = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    vacancy.setTitle(elementTitle.text());
                    Element elementSalary = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    vacancy.setSalary(elementSalary != null?elementSalary.text():"");
                    Element elementCity = element.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    vacancy.setCity(elementCity.text());
                    Element elementCompany = element.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    vacancy.setCompanyName(elementCompany.text());
                    vacancy.setSiteName("http://hh.ua/");
                    vacancy.setUrl(elementTitle.attr("href"));
                    list.add(vacancy);
                }
            }
        }
        catch (IOException e)
        {
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).timeout(TIMEOUT).get();
        return doc;
    }
}
