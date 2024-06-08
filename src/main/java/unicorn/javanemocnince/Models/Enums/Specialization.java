package unicorn.javanemocnince.Models.Enums;

import lombok.Getter;

@Getter
public enum Specialization {
    FIRST(1),
    SECOND(2),
    THIRD(3);

    public Integer specializationId;

    Specialization(Integer specializationId){
        this.specializationId = specializationId;
    }
}
