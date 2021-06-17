import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { AuthGuard } from './_helpers';

const accountModule = () => import('./account/account.module').then(x => x.AccountModule);
const usersModule = () => import('./users/users.module').then(x => x.UsersModule);
const transactionModule = () => import('./transaction/transaction.module').then(x => x.TransactionModule);
const viewtransactionModule = () => import('./viewtransaction/viewtransaction.module').then(x => x.ViewtransactionModule);

const routes: Routes = [
    { path: '', component: HomeComponent},
    { path: 'users', loadChildren: usersModule,canActivate:[AuthGuard] },
    { path: 'account', loadChildren: accountModule },
    { path: 'transaction', loadChildren: transactionModule,canActivate:[AuthGuard]  },
    { path: 'mytransaction', loadChildren: viewtransactionModule,canActivate:[AuthGuard]  },
    //mytransaction
    

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }