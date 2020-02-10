import { TestBed } from '@angular/core/testing';

import { GetRegistersService } from './get-registers.service';

describe('GetRegistersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetRegistersService = TestBed.get(GetRegistersService);
    expect(service).toBeTruthy();
  });
});
