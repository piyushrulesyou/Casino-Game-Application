import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/index';
import { GameResult } from '../model/game_result.model';
import { playingUri } from '../constants/uri';

@Injectable({
  providedIn: 'root'
})
export class PlayingService {

  private readonly gamePlayURI = playingUri;

  constructor(private httpClient: HttpClient) { }

  generateResult(customerID: string, amount: number, betSegment: number): Observable<GameResult> {
    return this.httpClient.get<GameResult>(this.gamePlayURI + '/' + customerID + '/' + amount + '/' + betSegment);
  };
}
