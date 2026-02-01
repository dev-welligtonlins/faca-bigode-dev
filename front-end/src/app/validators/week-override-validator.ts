import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function weekOverrideValidator(): ValidatorFn {
  return (group: AbstractControl): ValidationErrors | null => {

    const day = group.get('day')?.value;
    const opening = group.get('openingTime')?.value;
    const closing = group.get('closingTime')?.value;

    if (!day) {
      return null; // nenhum override selecionado
    }

    return opening && closing ? null : { overrideInvalid: true };
  };
}