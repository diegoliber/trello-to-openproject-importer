import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AccountFormComponent } from './account/account.component';

const appRoutes : Routes = [
    {path: '', component: HomeComponent },
    {path: 'account', component: AccountFormComponent},
    {path: '**', component: HomeComponent }
]

export const routing = RouterModule.forRoot(appRoutes);