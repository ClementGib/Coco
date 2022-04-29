
### Numérotation des étapes avec explication:
Source idea : https://loiane.com/2017/08/angular-reactive-forms-trigger-validation-on-submit/

Exemple :

`
```java
validateAllFormFields(formGroup: FormGroup) {         //{1}
  Object.keys(formGroup.controls).forEach(field => {  //{2}
    const control = formGroup.get(field);             //{3}
    if (control instanceof FormControl) {             //{4}
      control.markAsTouched({ onlySelf: true });
    } else if (control instanceof FormGroup) {        //{5}
      this.validateAllFormFields(control);            //{6}
    }
  });
}
```

A Reactive Form is an instance of FormGroup ({1}). So our method will receive the reference of the form. We will iterate throughout each key of the form ({2}) and will retrieve the control object ({3}). Now comes the important part. A form can have a FormControl, which we can say it is a field or it can have a FormGroup, which is a group of fields. If it is a field ({4}), then we mark the control as touched (or dirty according to the logic applied in your project). If it is a group of fields ({5}), then we need to call the same method again ({6}) until all levels of the form controls have been validated.
`
