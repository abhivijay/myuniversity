import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { TransactionRoutingModule } from './transaction-routing.module';
import { LayoutComponent } from './layout.component';
import { RegisterComponent } from './register.component';
import { DisplayComponent } from './display.component';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        TransactionRoutingModule
    ],
    declarations: [
        LayoutComponent,
        
        RegisterComponent,
        DisplayComponent
    ]
})
export class TransactionModule { }