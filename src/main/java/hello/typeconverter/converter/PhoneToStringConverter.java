package hello.typeconverter.converter;

import hello.typeconverter.type.Phone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class PhoneToStringConverter implements Converter<Phone, String> {
    @Override
    public String convert(Phone source) {
        log.info("convert source={}", source);
        // "010-xxxx-xxxx" 형태로 변한
        return source.getTel1() + "-" + source.getTel2() + "-" + source.getTel3();
    }
}
