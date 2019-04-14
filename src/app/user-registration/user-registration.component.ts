import { Component, OnInit } from '@angular/core';
import {UserService} from '../_services/user.service';
import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { User } from '../_models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user: User;
  message: string;
  formgroup: FormGroup;

  constructor(private fb: FormBuilder, private serviceUser: UserService, private router: Router) {
    this.createform();
  }

createform() {
    this.formgroup = this.fb.group({
        userfirst: ['', Validators.required],
        usermiddle: ['', Validators.required] ,
        userlast: ['', Validators.required] ,
        userdob: ['', Validators.required] ,
        gender: ['', Validators.required] ,
        userpermaddr: ['', Validators.required] ,
        userpresentaddr: ['', Validators.required] ,
        useroccupation: ['', Validators.required] ,
        usersalary: ['', Validators.required] ,
        marital: ['', Validators.required] ,
        userchildren: ['', Validators.required] ,
        useremail: ['', Validators.required] ,
        userphone: ['', Validators.required] ,
        userpan: ['', Validators.required] ,
    });
  }

ngOnInit() {
  }

  submit() {
      console.log(this.formgroup.value);
      this.user = this.formgroup.value;
      this.serviceUser.registerUser(this.user).subscribe((data) => {
          this.message = 'User is Registered Successfully'; });
          alert(this.message);
            this.formgroup.reset({
          userfirst: '',
          usermiddle: '',
          userlast: '',
          userdob: '',
          gender: '' ,
          Address: '',
          userpermaddr: '',
          userpresentaddr: '',
          useroccupation: '',
          usersalary: '',
          marital: '',
          userchildren: '',
          useremail: '',
          userphone: '',
          userpan: ''
      });
      this.router.navigate(['/customer-home.component']);

  }

}
