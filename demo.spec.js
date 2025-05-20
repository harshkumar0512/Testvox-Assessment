import { test, expect } from '@playwright/test';

test.describe('Text Box Form', () => {
  test('should fill the form and validate output', async ({ page }) => {
    await page.goto('https://demoqa.com/text-box');

    // Fill the form fields
    await page.locator('#userName').fill('John Doe');
    await page.locator('#userEmail').fill('john.doe@example.com');
    await page.locator('#currentAddress').fill('123 Main St');
    await page.locator('#permanentAddress').fill('456 Side Ave');

    // Submit the form
    await page.locator('#submit').click();

    // Assert output
    await expect(page.locator('#output #name')).toHaveText('Name:John Doe');
    await expect(page.locator('#output #email')).toHaveText('Email:john.doe@example.com');
    await expect(page.locator('#output #currentAddress')).toHaveText('Current Address :123 Main St');
    await expect(page.locator('#output #permanentAddress')).toHaveText('Permananet Address :456 Side Ave');
  });
});