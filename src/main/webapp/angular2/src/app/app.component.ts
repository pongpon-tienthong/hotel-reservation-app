import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public submitted: boolean;
  roomSearch: FormGroup;
  rooms: Room[];
  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
  }

  onSubmit({value, valid}: { value: Roomsearch, valid: boolean }) {
    this.getAll();
  }

  reserveRoom(value: string) {
    console.log("Room id for reservation:" + value);
  }

  getAll(): void {
    this.http
      .get(`${this.baseUrl}/room/reservation/v1/?checkin=2017-03-18&checkout=2016-03-18`)
      .subscribe(res => this.rooms = res['content']);
  }
}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}
