import { Component, Output, EventEmitter, OnInit, OnDestroy, NgZone } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-verify-code-component',
  templateUrl: './verify-code-component.html',
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class VerifyCodeComponent implements OnInit, OnDestroy {
  @Output() requestNewCode = new EventEmitter<void>();
  @Output() verified = new EventEmitter<void>();

  code: string = '';
  newPassword: string = '';
  confirmPassword: string = '';

  countdown = 60; // segundos
  private intervalId: any = null;

  constructor(private ngZone: NgZone) {}

  ngOnInit() {
    this.startCountdown();
  }

  ngOnDestroy() {
    this.clearCountdown();
  }

  private startCountdown() {
    this.clearCountdown();
    this.countdown = 60;

    // Rodar o setInterval fora da zone para não disparar change detection a cada tick,
    // mas executar a atualização dentro da zone para que Angular atualize a view.
    this.ngZone.runOutsideAngular(() => {
      this.intervalId = setInterval(() => {
        this.ngZone.run(() => {
          this.countdown--;
          if (this.countdown <= 0) {
            this.clearCountdown();
          }
        });
      }, 1000);
    });
  }

  private clearCountdown() {
    if (this.intervalId !== null) {
      clearInterval(this.intervalId);
      this.intervalId = null;
    }
  }

  onResendClick() {
    // opcional: chamar API para reenviar código aqui
    this.clearCountdown();
    this.requestNewCode.emit();
  }

  onSubmit() {
    if (this.newPassword !== this.confirmPassword) {
      alert('As senhas não coincidem');
      return;
    }
    // TODO: enviar código + nova senha para backend
    // se sucesso:
    this.verified.emit();
  }
}