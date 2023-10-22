package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}", text, locale);
        // "1,000" -> 1000
        // 문자를 숫자로
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        return numberFormat.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        // locale 정보를 활용해서 나라마다 다른 숫자 포맷을 만들어준다.
        // Number는 Integer, long과 같은 숫자 타입의 부모 클래스
        // 숫자를 문자로
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);

    }
}
