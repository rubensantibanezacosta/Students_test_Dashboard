import { TestBed } from '@angular/core/testing';

import { CalificationsService } from './califications.service';

describe('CalificationsService', () => {
  let service: CalificationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalificationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
