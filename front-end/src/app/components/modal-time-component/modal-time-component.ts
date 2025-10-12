import { isPlatformBrowser } from '@angular/common';
import { Component, ElementRef, Inject, PLATFORM_ID, ViewChild } from '@angular/core';
import { Modal } from 'bootstrap';

@Component({
  selector: 'app-modal-time-component',
  standalone: true,
  imports: [],
  templateUrl: './modal-time-component.html',
  styleUrl: './modal-time-component.scss'
})
export class ModalTimeComponent {
  @ViewChild('modalTime') modalTime!: ElementRef;
  private modal: any;
  isBrowser: boolean;

  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  async ngAfterViewInit() {
    if (this.isBrowser) {
      const bootstrap = await import('bootstrap');
      this.modal = new bootstrap.Modal(this.modalTime.nativeElement);
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
