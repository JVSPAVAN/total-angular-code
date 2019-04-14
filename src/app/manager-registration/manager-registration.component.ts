import { Component, OnInit } from '@angular/core';
import {ManagerService} from '../_services/manager.service';
import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Manager } from '../_models/manager';

@Component({
  selector: 'app-manager-registration',
  templateUrl: './manager-registration.component.html',
  styleUrls: ['./manager-registration.component.css']
})
export class ManagerRegistrationComponent implements OnInit {
  manager: Manager;
  message: string;
  formgroup: FormGroup;
  constructor(private fb: FormBuilder, private serviceManager: ManagerService) {
          this.createform();

   }
   createform() {
    this.formgroup = this.fb.group({
        mangfirst: ['', Validators.required],
        mangdob: ['', Validators.required] ,
        mangstate: ['', Validators.required] ,
        mangzone: ['', Validators.required] ,
        mangdesg: ['', Validators.required] ,
        mangemail: ['', Validators.required]
    });
  }
  ngOnInit() {
  }
   submitManager() {
      console.log(this.formgroup.value);
      this.manager = this.formgroup.value;
      this.serviceManager.registerManager(this.manager).subscribe((data) => {
          this.message = 'Agent is Registered Successfully'; });
            this.formgroup.reset({
        mangfirst: '',
        mangdob: '',
        mangstate: '',
        mangzone: '' ,
        mangdesg: '' ,
        mangemail: ''
      });
  }

}
