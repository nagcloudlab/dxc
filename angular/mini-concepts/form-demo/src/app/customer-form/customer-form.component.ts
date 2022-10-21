import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';

import * as CustomerFormValidators from './customer-form-validators'

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  customerForm!: FormGroup
  errors: any = {}

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {

    this.customerForm = this.fb.group({
      firstName: ['Nag', [Validators.required, Validators.minLength(3)]],
      lastName: ['N', Validators.required],
      email: ['nag@mail.com', [Validators.required, Validators.email]],
      confirmEmail: ['nag@mail.com', [Validators.required]],
      mobile: [''],
      noti: ['email'],
      addresses: this.fb.array([])
    })

    const firstNameControl = this.customerForm.controls['firstName'];
    const mobileControl = this.customerForm.controls['mobile'];
    const notiControl = this.customerForm.controls['noti'];

    // firstNameControl
    //   .valueChanges
    //   .subscribe({
    //     next: value => {
    //       console.log(value)
    //     }
    //   })

    // firstNameControl
    //   .statusChanges
    //   .subscribe({
    //     next: status => {
    //       if (status === "INVALID") {
    //         if (firstNameControl.errors?.['required']) {
    //           this.errors['firstName'] = "Please enter first name"
    //         }
    //         if (firstNameControl.errors?.['minlength']) {
    //           this.errors['firstName'] = "Please enter min 3 chars"
    //         }
    //       } else {
    //         this.errors['firstName'] = ""
    //       }
    //     }
    //   })

    // notiControl
    //   .valueChanges
    //   .subscribe(value => {
    //     if (value === "sms") {
    //       mobileControl.setValidators([Validators.required])
    //       mobileControl.updateValueAndValidity()
    //     } else {
    //       mobileControl.clearValidators()
    //     }
    //   })

  }

  get addresses() {
    return this.customerForm.controls["addresses"] as FormArray;
  }


  addNewAddress() {
    const address = this.fb.group({
      line1: ['', Validators.required],
      line2: ['', Validators.required],
      city: ['', Validators.required]
    });
    this.addresses.push(address)
  }

  handleFormSubmit(event: any) {
    event.preventDefault();
    console.log(this.customerForm.value)
  }

  loadCustomer(){

    let customer={
      firstName:"dxc",
      email:"dxc@mail.com",
      mobile:"1234567890",
    }

    // this.customerForm.setValue(customer)
    this.customerForm.patchValue(customer)

  }

}
