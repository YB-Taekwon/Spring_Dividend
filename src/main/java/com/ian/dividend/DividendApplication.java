package com.ian.dividend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DividendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DividendApplication.class, args);

        try {
            // 1. 웹 페이지 요청 -> HTML 가져오기
            String url = "https://finance.yahoo.com/quote/COKE/history/?frequency=1mo&period1=99153000&period2=1744195511";
            Document document = Jsoup.connect(url).get();

            // 2. 특정 태그 선택 (CSS의 선택자 사용 가능)
            // select First() == select().get(0)
            Element tbody = document.selectFirst("tbody"); // table 태그 전체

            // children: Element로 가져온 태그의 바로 하위 태그를 가져옴
            // children().get(n) == child(n)
            for (Element tr : tbody.children()) {
                String text = tr.text();
                if (!text.endsWith("Dividend"))
                    continue;

                // 3. 원하는 데이터 파싱
                String[] split = text.split(" ");
                String month = split[0];
                int day = Integer.parseInt(split[1].replace(",", ""));
                int year = Integer.parseInt(split[2]);
                String dividend = split[3];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}