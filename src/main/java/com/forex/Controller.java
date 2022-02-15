package com.forex;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {


    @GetMapping("/getUsApi")
    public List<List<String>> test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
//        https://rate.bot.com.tw/xrt/flcsv/0/2022-01-10 下載CSV連結
//        https://rate.bot.com.tw/xrt/flcsv/0/day 台銀當天匯率
//        String url;
//
        List<List<String>> records = new ArrayList<>();
        URL forexURL = new URL("https://rate.bot.com.tw/xrt/flcsv/0/day");
        BufferedReader in = new BufferedReader(new InputStreamReader(forexURL.openStream()));
        String line;
        ArrayList<String> arrayList = new ArrayList();


        while ((line = in.readLine()) != null) {
//            System.out.println("."+line.split(","));
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
        }
        System.out.print(records.get(1).get(0) + "  ");
        System.out.println(records.get(1).get(2));
        System.out.println("1現金位置 "+records.get(0).indexOf("現金"));
        System.out.println(records.get(0).toString());
        System.out.println("2現金位置 "+records.get(0).toString().indexOf("現金"));

        System.out.println(records.get(0).lastIndexOf("現金"));

        System.out.println(records.size());
        String us = "USD";
        int usIndex;

        for(int i=0; i < records.size(); i++){
            if(us.equals(records.get(i).get(0))){
               usIndex = i;
                System.out.println("USD位置"+i);
            }
        }


//        for(List<String> record : records){
//            System.out.println(record);
//        }

        return records;

//        CSVReader reader = new CSVReader(in);
//
//        System.out.println(reader.getRecordsRead());

        ////////////////////////////////////////////////////////////////////////
//        https://rate.bot.com.tw/xrt/flcsv/0/2022-01-10 !!歷史連結
//        https://rate.bot.com.tw/xrt/flcsv/0/day !!當天連結


//        URL url = new URL("https://rate.bot.com.tw/xrt/flcsv/0/day");
//        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase();
//
//        try(CSVParser csvParser = CSVParser.parse(url, StandardCharsets.UTF_8, csvFormat)) {
//
//            System.out.println(csvParser.getRecords());
//            for(CSVRecord csvRecord : csvParser) {
//                String firstName = csvRecord.get("現金");
//
//
//                System.out.println(firstName);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    @RequestMapping("/get1")
//    public void restTemplate(){
//       ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8080/test",String.class);
//        System.out.println(result);
//    }

}
