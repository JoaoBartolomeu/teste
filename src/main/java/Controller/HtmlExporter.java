package main.java.Controller;

import main.java.Interfaces.Exporter;
import main.java.Model.SummaryStatistics;

public class HtmlExporter implements Exporter {
    @Override
    public String exporter(SummaryStatistics summarySatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<h1>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong></li>: " + summarySatistics.getSum();
        result += "<li<<strong>The max is</strong></li>: " + summarySatistics.getMax();
        result += "<li><strong>The min is</strong></li>: " + summarySatistics.getMin();
        result += "<li><strong>The average is</strong></li>: " + summarySatistics.getAverage();
        result += "</ul>";
        result += "</body>";
        result += "</html>";

        return result;
    }
}
