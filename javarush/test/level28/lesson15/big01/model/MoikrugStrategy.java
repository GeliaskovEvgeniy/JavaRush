package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://http://javarush.ru/vacancies?page=%d&q=java+%s";
    private static final int TIMEOUT = 5 * 1000;
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    private static final String referrer = "http://javarush.ru/testdata/big28data2.html";

    @Override
    public List<Vacancy> getVacancies(String searchString){
        int num = 0;
        List<Vacancy> list = new ArrayList<>();
        try
        {
            while (true)
            {
                /*Document doc = getDocument(searchString, num++);
                Elements elements = doc.select("[class=job]");
                if (elements.size() == 0)
                    break;
                for(Element element : elements){
                    Vacancy vacancy = new Vacancy();
                    Element elementTitle = element.select("[class=title]>a").first();
                    vacancy.setTitle(elementTitle.text());
                    Element elementSalary = element.select("[class=salary]>[class=count]>b").first();
                    vacancy.setSalary(elementSalary != null?elementSalary.text():"");
                    Element elementCity = element.select("[class=meta]>[class=location]>a").first();
                    vacancy.setCity(elementCity.text());
                    Element elementCompany = element.select("[class=company_name]>a").first();
                    vacancy.setCompanyName(elementCompany.text());
                    vacancy.setSiteName("https://moikrug.ru/");
                    vacancy.setUrl(elementTitle.attr("href"));
                    list.add(vacancy);*/
                Document doc = getDocument(searchString, num++);
                Elements vacancyElements = doc.getElementsByClass("job");
                if (vacancyElements.size() > 0)
                {
                    for (Element element : vacancyElements)
                    {
                        Vacancy v = new Vacancy();
                        String vTitle = element.getElementsByClass("title").select("a").text();
                        v.setTitle(vTitle);
                        String vSalary = element.getElementsByClass("count").text();
                        v.setSalary(vSalary);
                        String vCity = element.getElementsByClass("location").text();
                        v.setCity(vCity);
                        String vCompanyName = element.getElementsByClass("company_name").select("a[href]").text();
                        v.setCompanyName(vCompanyName);
                        v.setSiteName("https://moikrug.ru");
                        String vURL = element.getElementsByClass("title").select("a").attr("abs:href");
                        v.setUrl(vURL);
                        list.add(v);
                    }
                }
            }
        }
        catch (IOException e)
        {
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, page, searchString);
        Document doc = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).timeout(TIMEOUT).get();
        return doc;
    }
}
