const { pathsToModuleNameMapper } = require('ts-jest')
const { paths } = require('./tsconfig.json').compilerOptions

module.exports = {
    roots: ['<rootDir>'],
    preset: 'jest-preset-angular',
    globalSetup: 'jest-preset-angular/global-setup',
    setupFilesAfterEnv: ['<rootDir>/setup-jest.ts'],
    moduleFileExtensions: ['ts', 'tsx', 'js', 'json', 'node'],
    moduleDirectories: ['node_modules', 'src/app/core/sevices'],
    moduleNameMapper: pathsToModuleNameMapper(paths, { prefix: '<rootDir>/src' }),
}
