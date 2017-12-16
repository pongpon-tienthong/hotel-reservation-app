import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public submitted: boolean;
  roomSearch: FormGroup;

  ngOnInit(): void {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
  }

  onSubmit({value, valid}: { value: Roomsearch, valid: boolean }) {
    console.log(value);
    console.log(valid);
  }
}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}
