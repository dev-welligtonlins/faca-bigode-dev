import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ServiceSchedule } from '../../services/ServiceSchedule';
import { CommonModule, WeekDay } from '@angular/common';
import { NewScheduleModel } from '../../models/new-schedule-model';
import { weekOverrideValidator } from '../../validators/week-override-validator';

@Component({
  selector: 'app-perfil-barbershop-form-schedule-component',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './perfil-barbershop-form-schedule-component.html',
  styleUrl: './perfil-barbershop-form-schedule-component.scss'
})
export class PerfilBarbershopFormScheduleComponent {
  scheduleForm!: FormGroup;

  constructor(private service: ServiceSchedule,  private fb: FormBuilder) {}

  ngOnInit(): void {
    this.scheduleForm = this.fb.group({
      // Horários de segunda a sexta
      week: this.fb.group({
        openingTime: ['', Validators.required],
        lunchStartTime: [''],
        lunchEndTime: [''],
        closingTime: ['', Validators.required],
      }),

      // Quando um dia da semana tem horário diferente
      weekOverrides: this.fb.group({
        day: [null],
        openingTime: [''],
        lunchStartTime: [''],
        lunchEndTime: [''],
        closingTime: [''],        
      }, {validators: weekOverrideValidator()}
      ),
      // Sabado
      saturday: this.fb.group({
        openingTime: ['', Validators.required],
        lunchStartTime: [''],
        lunchEndTime: [''],
        closingTime: ['', Validators.required],
      }),
      // Domingo
      sunday: this.fb.group({
        openingTime: ['', Validators.required],
        lunchStartTime: [''],
        lunchEndTime: [''],
        closingTime: ['', Validators.required],
      }),

      barbershopId: [0, Validators.required]

    });

  }

  // salva os dados - 'POST'
  postSchedules() : void {
    if (this.scheduleForm.invalid) {
      this.scheduleForm.markAllAsTouched();
      return;
    }

    const schedulesArray = this.getScheduleForm();
    console.log(schedulesArray)
    this.service.postSchedules(schedulesArray).subscribe({
      next: () => console.log('Salvo com sucesso!'),
      error: err => console.error(err)
    })
  }

  // Acessa os dados do formulario e distribui para os dias da semana
  getScheduleForm() : NewScheduleModel[] {
    const week = this.scheduleForm.value.week;
    const override = this.scheduleForm.value.weekOverrides;
    const saturday = this.scheduleForm.value.saturday;
    const sunday = this.scheduleForm.value.sunday;
    const barbershop= this.scheduleForm.value.barbershopId;

    const weekdays: NewScheduleModel['dayWeek'][] = [
      'MONDAY',' TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY'
    ];

    return [ 
      ...weekdays.map(day => {
        const data = override?.day === day ? override : week;

        return {
          dayWeek: day,
          openingTime: this.normalizeTime(data.openingTime),
          lunchStartTime: this.normalizeTime(data.lunchStartTime),
          lunchEndTime: this.normalizeTime(data.lunchEndTime),
          closingTime: this.normalizeTime(data.closingTime),
          barbershopId: barbershop
        };
      }),
      {
        dayWeek: 'SATURDAY',
        openingTime: this.normalizeTime(saturday.openingTime),
        lunchStartTime: this.normalizeTime(saturday.lunchStartTime),
        lunchEndTime: this.normalizeTime(saturday.lunchEndTime),
        closingTime: this.normalizeTime(saturday.closingTime),
        barbershopId: barbershop
      },

      {
        dayWeek: 'SUNDAY',
        openingTime: this.normalizeTime(sunday.openingTime),
        lunchStartTime: this.normalizeTime(sunday.lunchStartTime),
        lunchEndTime: this.normalizeTime(sunday.lunchEndTime),
        closingTime: this.normalizeTime(sunday.closingTime),
        barbershopId: barbershop
      }
    ];
  }

  normalizeTime(time: string): string {
    if (!time) return time;
    return time.length === 5 ? `${time}:00` : time;
  }

  get overrideGroup(): FormGroup {
    return this.scheduleForm.get('weekOverrides') as FormGroup;
  }

}

