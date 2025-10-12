import { Component, EventEmitter, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-register-form-component',
  standalone: true,
  imports: [],
  templateUrl: './register-form-component.html',
  styleUrl: './register-form-component.scss'
})
export class RegisterFormComponent {
  @Output() submitForm = new EventEmitter<void>();

  onSubmit() {
    this.submitForm.emit();
  }
}
