import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { RouterModule, Routes } from '@angular/router';
import { AgentRegistrationComponent } from './agent-registration/agent-registration.component';
import { ManagerRegistrationComponent } from './manager-registration/manager-registration.component';

import { HomeComponent } from './home/home.component';
import {UserService} from './_services/user.service';
import {AgentService} from './_services/agent.service';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { UserViewComponent } from './user-view/user-view.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { UserDeleteComponent } from './user-delete/user-delete.component';

const appRoutes: Routes = [
   { path: 'user-registration', component: UserRegistrationComponent },
     { path: 'agent-registration', component: AgentRegistrationComponent },
     { path: 'manager-registration', component: ManagerRegistrationComponent },
          { path: 'home', component: HomeComponent },
          { path: 'user-view', component: UserViewComponent },
          { path: 'user-update', component: UserUpdateComponent },
          { path: 'user-delete', component: UserDeleteComponent },
          { path: 'customer-home', component: CustomerHomeComponent }
          {path: '', component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    AgentRegistrationComponent,
    ManagerRegistrationComponent,
    HomeComponent,
    CustomerHomeComponent,
    UserViewComponent,
    UserUpdateComponent,
    UserDeleteComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService, AgentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
