package com.inclub.apibackofficeadmin.domain.models.Membresias;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("state")
public class State {

    @Id
    @Getter
    @Setter
    @Column("idstate")
    private int idState;
    @Getter
    @Setter
    @Column("namestate")
    private String nameState;
    @Getter
    @Setter
    @Column("colorrgb")
    private String colorRGB;

    public State() {
    }
    public State(int idState, String nameState, String colorRGB) {
        this.idState = idState;
        this.nameState = nameState;
        this.colorRGB = colorRGB;
    }
    public State(String nameState, String colorRGB) {
        this.nameState = nameState;
        this.colorRGB = colorRGB;
    }
}
