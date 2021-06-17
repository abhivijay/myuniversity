import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { AccountService } from '@app/_services';
import { User } from '@app/_models/user';

@Component({ templateUrl: 'profile.component.html' })
export class ProfileComponent{
    

    user: User;

    constructor(private accountService: AccountService) {
        this.user = this.accountService.userValue;
    }

    

    
}