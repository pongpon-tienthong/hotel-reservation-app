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
  private postUrl: string = `${this.baseUrl}/room/reservation/v1`;
  currentCheckInVal: string;
  currentCheckOutVal: string;
  request: ReserveRoomRequest;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });


    const roomSearchValueChanges$ = this.roomSearch.valueChanges;

    // subscribe to the stream
    roomSearchValueChanges$.subscribe(x => {
      this.currentCheckInVal = x.checkin;
      this.currentCheckOutVal = x.checkout;
    });
  }

  onSubmit({value, valid}: { value: Roomsearch, valid: boolean }) {
    this.getAll();
  }

  getAll(): void {
    this.http
      .get(`${this.baseUrl}/room/reservation/v1/?checkin=2017-03-18&checkout=2016-03-18`)
      .subscribe(res => this.rooms = res['content']);
  }

  reserveRoom(roomId: string): void {
    this.request = new ReserveRoomRequest(roomId, this.currentCheckInVal, this.currentCheckOutVal);
    this.http.post(this.postUrl, this.request).subscribe(res => {
      console.log(res);
    });
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

export class ReserveRoomRequest {
  roomId: string;
  checkin: string;
  checkout: string;

  constructor(roomId: string,
              checkin: string,
              checkout: string) {

    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}
