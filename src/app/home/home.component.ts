
import { Component, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import { UserRegistrationComponent } from '../user-registration/user-registration.component';
import { RouterModule, Routes } from '@angular/router';
import { AgentRegistrationComponent } from '../agent-registration/agent-registration.component';
import { ManagerRegistrationComponent } from '../manager-registration/manager-registration.component';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
