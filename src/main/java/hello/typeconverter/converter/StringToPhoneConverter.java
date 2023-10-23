package hello.typeconverter.converter;

import hello.typeconverter.type.Phone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToPhoneConverter implements Converter<String, Phone> {
    @Override
    public Phone convert(String source) {
        log.info("converter source={}", source);
        String[] split = source.split("-");
        String tel1 = split[0];
        int tel2 = Integer.parseInt(split[1]);
        int tel3 = Integer.parseInt(split[2]);
        // Phone 객체 값으로
        return new Phone(tel1, tel2, tel3);
    }
}
