package pl.aka.os.test.mapper;

import pl.aka.os.test.dto.CreatedBox.CreatedBoxResponseDto;
import pl.aka.os.test.model.Box;

public class BoxMapper {

    public static CreatedBoxResponseDto BoxToCratedBoxDto(Box box) {
        return new CreatedBoxResponseDto(
                box.getId()
        );
    }
}
