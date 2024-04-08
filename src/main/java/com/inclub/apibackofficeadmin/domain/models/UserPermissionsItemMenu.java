package com.inclub.apibackofficeadmin.domain.models;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public class UserPermissionsItemMenu {

    @Getter
    @Setter
    @Id
    private int id;

    @Getter
    @Setter
    private int idUser;

    @Getter
    @Setter
    private int idItemMenu;

    public UserPermissionsItemMenu() {
    }

    public UserPermissionsItemMenu(int idUser, int idItemMenu) {

        this.idUser = idUser;
        this.idItemMenu = idItemMenu;
    }


}
