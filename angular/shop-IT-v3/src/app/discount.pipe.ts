import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'discount'
})
export class DiscountPipe implements PipeTransform {

  transform(value: number, ...args: number[]): number {
    if (args.length === 0)
      return value - 1;
    else
      return value - args[0]
  }

}
