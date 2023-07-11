import os

def main():
    counter = 0
    directory_path = "/home/goldensunrise/Downloads/vidya-psmri-github/MMU-API"  # Path to the parent directory

    license_text = """/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
"""

    try:
        # Recursively search for files in all subdirectories of the parent directory
        search_files(directory_path, license_text, counter)
        print("License text added successfully to all {} java files.".format(counter))
    except Exception as e:
        print("Unexpected Error!")
        print(e)

def search_files(directory_path, license_text, counter):
    for root, dirs, files in os.walk(directory_path):
        for file_name in files:
            if file_name.endswith(".java"):
                file_path = os.path.join(root, file_name)
                add_license_text_to_file(file_path, license_text)
                counter += 1
    print("{} files have been changed".format(counter))

def add_license_text_to_file(file_path, license_text):
    # Read the existing content of the file
    with open(file_path, 'r') as file:
        existing_content = file.read()

    # Write the license text and existing content to the file
    with open(file_path, 'w') as file:
        file.write(license_text + existing_content)

if __name__ == "__main__":
    main()

