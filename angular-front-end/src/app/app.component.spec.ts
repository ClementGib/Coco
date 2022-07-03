import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { RouterTestingModule } from '@angular/router/testing';
import { AdminModule } from './admin/admin.module';
import { AppComponent } from './app.component';
import { CourseModule } from './course/course.module';
import { SharedModule } from './shared/shared.module';

describe('AppComponent', () => {
    let fixture: ComponentFixture<AppComponent>;
    let component: AppComponent;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [
                RouterTestingModule,
                HttpClientTestingModule,
                SharedModule,
                CourseModule,
            ],
            declarations: [
                AppComponent
            ],
        }).compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(AppComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create the app', () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.componentInstance;
        expect(app).toBeTruthy();
    });

    describe('Should correctly initialize app component', () => {
        it('should have as title coco-front-end', () => {
            const fixture = TestBed.createComponent(AppComponent);
            const app = fixture.componentInstance;
            expect(app.title).toEqual('coco-front-end');
        });

        it('When initialize app it should create components', () => {
            const appComponentRows = fixture.debugElement.queryAll(By.css('.page-container'));

            expect(appComponentRows[0].children.length).toEqual(3);
        });

        it('When initialize app it should create header', () => {
            const appComponentRows = fixture.debugElement.queryAll(By.css('.page-container'));

            expect(appComponentRows[0].children[0].name).toEqual('app-header');
        });

        it('When initialize app it should create body content', () => {
            const appComponentRows = fixture.debugElement.queryAll(By.css('.body-content'));

            expect(appComponentRows[0].children[0].name).toEqual('router-outlet');
        });

        it('When initialize app it should create footer', () => {
            const appComponentRows = fixture.debugElement.queryAll(By.css('.page-container'));

            expect(appComponentRows[0].children[2].name).toEqual('app-footer');
        });
    });
});
