import {Component, inject} from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'not-found',
  template: `
    <div class="w-screen h-screen grid place-items-center p-4 select-none">
      <div class="flex flex-col justify-center items-center">
        <h1 class="text-teal-600 text-center font-bold text-7xl animate-bounce">404</h1>
        <button class="mt-2 px-16 cursor-pointer py-2 border hover:border-teal-500" (click)="goBack()">Back</button>
      </div>
    </div>
  `,
})
export class NotFoundComponent {
  location: Location = inject(Location);

  goBack(): void {
    this.location.back();
  }
}
