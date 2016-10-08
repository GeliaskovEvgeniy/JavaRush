package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies) {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("oddesa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        try {
            Document document = getDocument();
            Element elements = document.getElementsByClass("template").first();
            Element cloneElements = elements.clone();
            cloneElements.removeClass("template");
            cloneElements.removeAttr("style");

            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancies) {
                Element vacancyClone = cloneElements.clone();
                vacancyClone.getElementsByClass("city").first().text(vacancy.getCity());
                vacancyClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                vacancyClone.getElementsByClass("salary").first().text(vacancy.getSalary());
                vacancyClone.getElementsByTag("a").first().text(vacancy.getTitle()).attr("href", vacancy.getUrl());
                elements.before(vacancyClone.outerHtml());
            }
            return document.html();
        }
        catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String s) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(s);
        writer.close();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
