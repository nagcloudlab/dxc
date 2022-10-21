import {AbstractControl} from "@angular/forms";


export function mobile(control: AbstractControl) {
  const value = control.value;
  if (/\d{10}/.test(value)) {
    return false;
  } else {
    return {mobile: true}
  }
}
