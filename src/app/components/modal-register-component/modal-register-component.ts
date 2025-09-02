import { isPlatformBrowser } from '@angular/common';
import { Component, ElementRef, Inject, PLATFORM_ID, ViewChild } from '@angular/core';
import { Modal } from 'bootstrap';

@Component({
  selector: 'app-modal-register-component',
  standalone: true,
  imports: [],
  templateUrl: './modal-register-component.html',
  styleUrl: './modal-register-component.scss'
})
export class ModalRegisterComponent {
  @ViewChild('modalRegister') modalRegister!: ElementRef;
  private modal: any;
  isBrowser: boolean;

  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  async ngAfterViewInit() {
    if (this.isBrowser) {
      const bootstrap = await import('bootstrap');
      this.modal = new bootstrap.Modal(this.modalRegister.nativeElement);
    }
  }

  openModal() {
    if (this.modal) {
      this.modal.show();
    }
  }

  closeModal() {
    if (this.modal) {
      this.modal.hide();
    }
  }
}
