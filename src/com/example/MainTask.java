package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainTask {

    public static void main(String[] args) throws IOException {
        List<Course> courseList = new ArrayList<>();

        Document doc = Jsoup.connect("https://www.udemy.com/course/learn-flutter-dart-to-build-ios-android-apps/").get();

        Elements greyElements = doc.getElementsByAttributeValue("class",
            "section--previewable-item--3C8nb udlite-block-list-item udlite-block-list-item-small udlite-block-list-item-link udlite-text-sm");
        Elements blueElements = doc.getElementsByAttributeValue("class",
            "udlite-btn udlite-btn-large udlite-btn-ghost udlite-text-sm section--previewable-item--3C8nb udlite-block-list-item udlite-block-list-item-small udlite-block-list-item-link");

        greyElements.forEach(element -> {
            String name = element.child(1).child(0).child(0).child(0).child(0).text();
            String duration = element.child(1).child(3).text();
            courseList.add(new Course(name, duration));
        });
        blueElements.forEach(element -> {
            String name = element.child(1).child(0).child(0).child(0).text();
            String duration = element.child(1).child(3).text();
            courseList.add(new Course(name, duration));
        });

        Collections.sort(courseList);
        courseList.forEach(System.out::println);

    }

}
