import { Component } from '@angular/core';

import { Transaction } from '@app/_models';
import { AccountService } from '@app/_services';

@Component({ templateUrl: 'display.component.html' })
export class DisplayComponent {
    transaction: Transaction;

    constructor(private accountService: AccountService) {
        this.transaction = this.accountService.transactionValue;
    }
}